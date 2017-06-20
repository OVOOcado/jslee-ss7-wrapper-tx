/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.ConnectSMSRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ConnectSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ConnectSMSRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxConnectSMSArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxConnectRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectSMSRequestEventWrapper extends TxEventWrapper implements ConnectSMSRequestEventWrapper {

    private final ConnectSMSRequest connectSMSRequest;

    public TxConnectSMSRequestEventWrapper(final ConnectSMSRequest connectSMSRequest, final ActivityContextInterface aci) {
        super(aci, connectSMSRequest);
        this.connectSMSRequest = connectSMSRequest;
    }

    @Override
    public ConnectSMSArgWrapper getArgument() throws Ss7WrapperException {
        final TxConnectSMSArgWrapper connectSMSArgWrapper = new TxConnectSMSArgWrapper();
        if (connectSMSRequest.getDestinationSubscriberNumber() != null) {
        	connectSMSArgWrapper.setTxDestinationSubscriberNumber(connectSMSRequest.getDestinationSubscriberNumber());
        }
        connectSMSArgWrapper.setTxSmscAddress(connectSMSRequest.getSMSCAddress());

        return connectSMSArgWrapper;
    }
}
