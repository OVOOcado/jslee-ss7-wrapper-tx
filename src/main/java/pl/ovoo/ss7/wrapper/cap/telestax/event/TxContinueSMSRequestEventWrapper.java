/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.ContinueSMSRequest;
import pl.ovoo.ss7.wrapper.cap.event.ContinueSMSRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxContinueRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxContinueSMSRequestEventWrapper extends TxEventWrapper implements ContinueSMSRequestEventWrapper {

    private final ContinueSMSRequest continueSMSRequest;

    public TxContinueSMSRequestEventWrapper(final ContinueSMSRequest continueSMSRequest, final ActivityContextInterface aci) {
        super(aci, continueSMSRequest);
        this.continueSMSRequest = continueSMSRequest;
    }
}
