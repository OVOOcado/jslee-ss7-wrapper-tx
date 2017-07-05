/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;
import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParsingComponentException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCFInfo;
import org.mobicents.protocols.ss7.map.service.mobility.subscriberInformation.SubscriberCFInfoImpl;

import pl.ovoo.ss7.wrapper.map.args.CFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SubscriberCFInfoWrapper;

/**
 * TxSubscriberCFInfoWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSubscriberCFInfoWrapper implements SubscriberCFInfoWrapper {

    private SubscriberCFInfo subscriberCFInfo;
    private CFInfoWrapper cFNoReplyTS10;
    private CFInfoWrapper cFSubscriberBusyTS10;
    private CFInfoWrapper cFSubscriberNotReachableTS10;

    private SubscriberCFInfoImpl subscriberCfInfoImpl;

    private static Logger logger = Logger.getLogger(TxSubscriberCFInfoWrapper.class);

    public TxSubscriberCFInfoWrapper(final SubscriberCFInfo subscriberCFInfo) {
        this.subscriberCFInfo = subscriberCFInfo;
        this.cFNoReplyTS10 = new TxCFInfoWrapper(new TxCFStatusWrapper(subscriberCFInfo.getTs10CfrnyStatus()),
                new TxForwardedToNumberWrapper((AddressString) subscriberCFInfo.getTs10CfrnyNumber()));
        this.cFSubscriberBusyTS10 = new TxCFInfoWrapper(new TxCFStatusWrapper(subscriberCFInfo.getTs10CfbStatus()),
                new TxForwardedToNumberWrapper((AddressString) subscriberCFInfo.getTs10CfbNumber()));
        this.cFSubscriberNotReachableTS10 = new TxCFInfoWrapper(
                new TxCFStatusWrapper(subscriberCFInfo.getTs10CfrncStatus()),
                new TxForwardedToNumberWrapper((AddressString) subscriberCFInfo.getTs10CfrncNumber()));

    }

    public TxSubscriberCFInfoWrapper() {

    }

    @Override
    public CFInfoWrapper getCFNoReplyTS10() {
        return cFNoReplyTS10;
    }

    @Override
    public CFInfoWrapper getCFSubscriberBusyTS10() {
        return cFSubscriberBusyTS10;
    }

    @Override
    public CFInfoWrapper getCFSubscriberNotReachableTS10() {
        return cFSubscriberNotReachableTS10;
    }

    @Override
    public boolean hasCFNoReplyTS10() {
        return cFNoReplyTS10 != null;
    }

    @Override
    public boolean hasCFSubscriberBusyTS10() {
        return cFSubscriberBusyTS10 != null;
    }

    @Override
    public boolean hasCFSubscriberNotReachableTS10() {
        return cFSubscriberNotReachableTS10 != null;
    }

    public SubscriberCFInfo getTxSubscriberCFInfo() {
        return subscriberCFInfo;
    }

    @Override
    public String toString() {
        return "TxSubscriberCFInfoWrapper [subscriberCFInfo=" + subscriberCFInfo + ", cFNoReplyTS10=" + cFNoReplyTS10
                + ", cFSubscriberBusyTS10=" + cFSubscriberBusyTS10 + ", cFSubscriberNotReachableTS10="
                + cFSubscriberNotReachableTS10 + "]";
    }

    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        subscriberCfInfoImpl = new SubscriberCFInfoImpl();
        byte[] byteArr = (byte[]) oin.readObject();
        AsnInputStream asnIs = new AsnInputStream(byteArr);

        try {
            this.subscriberCfInfoImpl.decodeData(asnIs, 0);
        } catch (MAPParsingComponentException e) {
            logger.info(e);
            e.printStackTrace();
        }
        asnIs.close();
        this.subscriberCFInfo = subscriberCfInfoImpl;
        this.cFNoReplyTS10 = (CFInfoWrapper) oin.readObject();
        this.cFSubscriberBusyTS10 = (CFInfoWrapper) oin.readObject();
        this.cFSubscriberNotReachableTS10 = (CFInfoWrapper) oin.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        this.subscriberCfInfoImpl = (SubscriberCFInfoImpl) subscriberCFInfo;
        AsnOutputStream asnOs = new AsnOutputStream();

        try {
            this.subscriberCfInfoImpl.encodeData(asnOs);
        } catch (MAPException e) {
            logger.info(e);
            e.printStackTrace();
        }
        byte[] byteArray = asnOs.toByteArray();
        asnOs.close();
        out.writeObject(byteArray);
        out.writeObject(this.cFNoReplyTS10);
        out.writeObject(this.cFSubscriberBusyTS10);
        out.writeObject(this.cFSubscriberNotReachableTS10);
    }

}
