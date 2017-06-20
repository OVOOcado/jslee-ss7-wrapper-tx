/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ConnectRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ConnectRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap1.TxCap1ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3ConnectArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxConnectRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectRequestEventWrapper extends TxEventWrapper implements ConnectRequestEventWrapper {

    private final ConnectRequest connectRequest;

    public TxConnectRequestEventWrapper(final ConnectRequest connectRequest, final ActivityContextInterface aci) {
        super(aci, connectRequest);
        this.connectRequest = connectRequest;
    }

    @Override
    public ConnectArgWrapper getArgument() throws Ss7WrapperException {
        final TxCap1ConnectArgWrapper connectArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                connectArgWrapper = new TxCap1ConnectArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                connectArgWrapper = new TxCap2ConnectArgWrapper();
                break;
            default:
                connectArgWrapper = new TxCap3ConnectArgWrapper();
        }
        if (connectRequest.getDestinationRoutingAddress() != null) {
            connectArgWrapper.setTxDestinationRoutingAddress(connectRequest.getDestinationRoutingAddress().getCalledPartyNumber());
        }
        connectArgWrapper.setTxOriginalCalledPartyID(connectRequest.getOriginalCalledPartyID());
        connectArgWrapper.setTxRedirectingPartyIDCap(connectRequest.getRedirectingPartyID());
        connectArgWrapper.setTxRedirectionInformationInap(connectRequest.getRedirectionInformation());

        return connectArgWrapper;
    }
}
