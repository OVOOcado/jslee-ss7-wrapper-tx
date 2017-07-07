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

package pl.ovoo.ss7.wrapper.cap.tx;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.Cap2CallCapDialogWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingReportArgWrapper;

/**
 * TxCap2CallCapDialogWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2CallCapDialogWrapper extends TxCap1CallCapDialogWrapper implements Cap2CallCapDialogWrapper {

    public TxCap2CallCapDialogWrapper(final CAPDialogCircuitSwitchedCall dialogCircuitSwitchedCall, final CAPProvider capProvider) {
        super(dialogCircuitSwitchedCall, capProvider);
    }

    @Override
    public int sendApplyChargingReport(final ApplyChargingReportArgWrapper applyChargingReportArg) throws Ss7WrapperException {
        final TxCap2ApplyChargingReportArgWrapper txApplyChargingReportArgWrapper = (TxCap2ApplyChargingReportArgWrapper) applyChargingReportArg;
        try {
            return dialogCircuitSwitchedCall.addApplyChargingReportRequest(txApplyChargingReportArgWrapper.getTxTimeDurationChargingResult()).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public int sendResetTimer(final ResetTimerArgWrapper resetTimerArgWrapper) throws Ss7WrapperException {
        final TxResetTimerArgWrapper txResetTimerArgWrapper = (TxResetTimerArgWrapper) resetTimerArgWrapper;
        try {
            return dialogCircuitSwitchedCall.addResetTimerRequest(txResetTimerArgWrapper.getTxTimerID(),
                    txResetTimerArgWrapper.getTxTimerValue(), null, null).intValue();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
