/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.Cap2CallCapDialogWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ApplyChargingReportArgWrapper;

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
