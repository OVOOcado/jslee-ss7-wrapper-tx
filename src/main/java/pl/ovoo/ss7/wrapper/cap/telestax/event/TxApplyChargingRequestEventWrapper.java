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

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ApplyChargingRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ApplyChargingRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3ApplyChargingArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxApplyChargingRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingRequestEventWrapper extends TxEventWrapper implements ApplyChargingRequestEventWrapper {

    private final ApplyChargingRequest applyChargingRequest;

    public TxApplyChargingRequestEventWrapper(final ApplyChargingRequest applyChargingRequest, final ActivityContextInterface aci) {
        super(aci, applyChargingRequest);
        this.applyChargingRequest = applyChargingRequest;
    }

    @Override
    public ApplyChargingArgWrapper getArgument() throws Ss7WrapperException {
        final TxApplyChargingArgWrapper applyChargingArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                applyChargingArgWrapper = new TxApplyChargingArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                applyChargingArgWrapper = new TxCap2ApplyChargingArgWrapper();
                break;
            default:
                applyChargingArgWrapper = new TxCap3ApplyChargingArgWrapper();
        }

        applyChargingArgWrapper.setTxAchBillingChargingCharacteristics(applyChargingRequest.getAChBillingChargingCharacteristics());
        applyChargingArgWrapper.setTxPartyToCharge(applyChargingRequest.getPartyToCharge());
        return applyChargingArgWrapper;
    }
}
