/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ResetTimerRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ResetTimerRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxResetTimerArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxResetTimerRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxResetTimerRequestEventWrapper extends TxEventWrapper implements ResetTimerRequestEventWrapper {

    private final ResetTimerRequest resetTimerRequest;

    public TxResetTimerRequestEventWrapper(final ResetTimerRequest resetTimerRequest, final ActivityContextInterface aci) {
        super(aci, resetTimerRequest);
        this.resetTimerRequest = resetTimerRequest;
    }

    @Override
    public ResetTimerArgWrapper getArgument() throws Ss7WrapperException {
        final TxResetTimerArgWrapper txResetTimerArgWrapper = new TxResetTimerArgWrapper();
        txResetTimerArgWrapper.setTxTimerID(resetTimerRequest.getTimerID());
        txResetTimerArgWrapper.setTxTimerValue(resetTimerRequest.getTimerValue());
        return txResetTimerArgWrapper;
    }
}
