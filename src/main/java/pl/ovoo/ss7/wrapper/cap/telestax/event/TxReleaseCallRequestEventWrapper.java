/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ReleaseCallRequest;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseCallArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ReleaseCallRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReleaseCallArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxReleaseCallRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseCallRequestEventWrapper extends TxEventWrapper implements ReleaseCallRequestEventWrapper {

    private final ReleaseCallRequest releaseCallRequest;

    public TxReleaseCallRequestEventWrapper(final ReleaseCallRequest releaseCallRequest, final ActivityContextInterface aci) {
        super(aci, releaseCallRequest);
        this.releaseCallRequest = releaseCallRequest;
    }

    @Override
    public ReleaseCallArgWrapper getArgument() throws Ss7WrapperException {
        try {
            final CauseIndicators causeIndicators;
            if (releaseCallRequest.getCause() != null) {
                causeIndicators = releaseCallRequest.getCause().getCauseIndicators();
            } else {
                causeIndicators = null;
            }
            final TxReleaseCallArgWrapper txReleaseCallArgWrapper = new TxReleaseCallArgWrapper();
            txReleaseCallArgWrapper.setTxCauseIndicators(causeIndicators);
            return txReleaseCallArgWrapper;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
