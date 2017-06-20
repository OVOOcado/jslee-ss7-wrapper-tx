/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.ReleaseSMSRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ReleaseSMSRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReleaseSMSArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxReleaseSMSRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseSMSRequestEventWrapper extends TxEventWrapper implements ReleaseSMSRequestEventWrapper {

    private final ReleaseSMSRequest releaseSMSRequest;

    public TxReleaseSMSRequestEventWrapper(final ReleaseSMSRequest releaseSMSRequest, final ActivityContextInterface aci) {
        super(aci, releaseSMSRequest);
        this.releaseSMSRequest = releaseSMSRequest;
    }

    @Override
    public ReleaseSMSArgWrapper getArgument() throws Ss7WrapperException {
        return new TxReleaseSMSArgWrapper(releaseSMSRequest.getRPCause());
    }
}
