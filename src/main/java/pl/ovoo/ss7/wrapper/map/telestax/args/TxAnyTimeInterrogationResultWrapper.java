/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParsingComponentException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCFInfo;
import org.mobicents.protocols.ss7.map.service.mobility.subscriberInformation.SubscriberCFInfoImpl;

import pl.ovoo.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SubscriberCFInfoWrapper;

/**
 * TxAnyTimeInterrogationResultWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationResultWrapper implements AnyTimeInterrogationResultWrapper {

    private SubscriberCFInfoWrapper subscriberCFInfoWrapper;
    private MAPSubscriberInfoWrapper subscriberInfoWrapper;

    private SubscriberCFInfoImpl subscriberCfInfoImpl;

    public TxAnyTimeInterrogationResultWrapper(final SubscriberCFInfoWrapper subscriberCFInfoWrapper,
            final MAPSubscriberInfoWrapper subscriberInfoWrapper) {
        super();
        this.subscriberCFInfoWrapper = subscriberCFInfoWrapper;
        this.subscriberInfoWrapper = subscriberInfoWrapper;
    }

    public TxAnyTimeInterrogationResultWrapper() {

    }

    @Override
    public MAPSubscriberInfoWrapper getSubscriberInfo() {
        return subscriberInfoWrapper;
    }

    @Override
    public SubscriberCFInfoWrapper getSubscriberCFInfo() {
        return subscriberCFInfoWrapper;
    }

    @Override
    public boolean hasSubscriberInfo() {
        return subscriberInfoWrapper != null;
    }

    @Override
    public boolean hasSubscriberCFInfo() {
        return subscriberCFInfoWrapper != null;
    }

    @Override
    public String toString() {
        return "TxAnyTimeInterrogationResultWrapper [subscriberCFInfoWrapper=" + subscriberCFInfoWrapper
                + ", subscriberInfoWrapper=" + subscriberInfoWrapper + "]";
    }

    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        this.subscriberCfInfoImpl = new SubscriberCFInfoImpl();
        byte[] byteArray = (byte[]) oin.readObject();
        AsnInputStream asnIs = new AsnInputStream(byteArray);

        try {
            subscriberCfInfoImpl.decodeData(asnIs, 0);
        } catch (MAPParsingComponentException e) {
            e.printStackTrace();
        }
        asnIs.close();
        TxSubscriberCFInfoWrapper txSubscriberCFInfoWrapper = new TxSubscriberCFInfoWrapper(subscriberCfInfoImpl);
        this.subscriberCFInfoWrapper = txSubscriberCFInfoWrapper;
        this.subscriberInfoWrapper = (MAPSubscriberInfoWrapper) oin.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        TxSubscriberCFInfoWrapper txSubscriberCFInfoWrapper = (TxSubscriberCFInfoWrapper) subscriberCFInfoWrapper;
        SubscriberCFInfo txSubscriberCFInfo = txSubscriberCFInfoWrapper.getTxSubscriberCFInfo();
        this.subscriberCfInfoImpl = (SubscriberCFInfoImpl) txSubscriberCFInfo;

        AsnOutputStream asnOs = new AsnOutputStream();
        try {
            subscriberCfInfoImpl.encodeData(asnOs);
        } catch (MAPException e) {
            e.printStackTrace();
        }
        byte[] byteArray = asnOs.toByteArray();
        asnOs.close();
        out.writeObject(byteArray);
        out.writeObject(subscriberInfoWrapper);
    }

}
