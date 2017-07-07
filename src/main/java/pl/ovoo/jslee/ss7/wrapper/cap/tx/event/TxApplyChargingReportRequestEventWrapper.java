/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ApplyChargingReportRequest;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ApplyChargingReportRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxApplyChargingReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingReportArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxApplyChargingReportRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingReportRequestEventWrapper extends TxEventWrapper implements ApplyChargingReportRequestEventWrapper {

    private final ApplyChargingReportRequest applyChargingReportRequestEvent;

    public TxApplyChargingReportRequestEventWrapper(final ApplyChargingReportRequest applyChargingReportRequestEvent, final ActivityContextInterface aci) {
        super(aci, applyChargingReportRequestEvent);
        this.applyChargingReportRequestEvent = applyChargingReportRequestEvent;
    }

    @Override
    public ApplyChargingReportArgWrapper getArgument() {
        final TxApplyChargingReportArgWrapper txApplyChargingReportArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txApplyChargingReportArgWrapper = new  TxApplyChargingReportArgWrapper();
                break;
            default:
                txApplyChargingReportArgWrapper = new TxCap2ApplyChargingReportArgWrapper();
        }
        if (txApplyChargingReportArgWrapper instanceof TxCap2ApplyChargingReportArgWrapper) {
            ((TxCap2ApplyChargingReportArgWrapper) txApplyChargingReportArgWrapper).setTxTimeDurationChargingResult(applyChargingReportRequestEvent.getTimeDurationChargingResult());
        }
        return txApplyChargingReportArgWrapper;
    }
}
