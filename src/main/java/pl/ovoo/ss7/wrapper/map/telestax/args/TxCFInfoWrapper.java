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

import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;
import org.mobicents.protocols.ss7.map.service.mobility.subscriberInformation.SubscriberCfStatusImpl;

import pl.ovoo.ss7.wrapper.map.args.CFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.CFStatusWrapper;
import pl.ovoo.ss7.wrapper.map.args.ForwardedToNumberWrapper;

/**
 * TxCFInfoWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxCFInfoWrapper implements CFInfoWrapper {

    private CFStatusWrapper cFStatusWrapper;
    private ForwardedToNumberWrapper forwardedToNumberWrapper;

    private SubscriberCfStatusImpl subscriberCfStatusImpl;

    public TxCFInfoWrapper(final CFStatusWrapper cFStatusWrapper,
            final ForwardedToNumberWrapper forwardedToNumberWrapper) {
        this.cFStatusWrapper = cFStatusWrapper;
        this.forwardedToNumberWrapper = forwardedToNumberWrapper;
    }

    public TxCFInfoWrapper() {
    }

    @Override
    public boolean hasForwardedToNumber() {
        return forwardedToNumberWrapper != null;
    }

    @Override
    public boolean hasCFStatus() {
        return cFStatusWrapper != null;
    }

    @Override
    public ForwardedToNumberWrapper getForwardedToNumber() {
        return forwardedToNumberWrapper;
    }

    @Override
    public CFStatusWrapper getCFStatus() {
        return cFStatusWrapper;
    }

    @Override
    public String toString() {
        return "TxCFInfoWrapper [cFStatusWrapper=" + cFStatusWrapper + ", forwardedToNumberWrapper="
                + forwardedToNumberWrapper + "]";
    }

    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        subscriberCfStatusImpl = new SubscriberCfStatusImpl();
        int readInt = oin.readInt();
        subscriberCfStatusImpl.decode(readInt);
        TxCFStatusWrapper txCFStatusWrapper = new TxCFStatusWrapper(subscriberCfStatusImpl);

        this.cFStatusWrapper = (CFStatusWrapper) txCFStatusWrapper;
        this.forwardedToNumberWrapper = (ForwardedToNumberWrapper) oin.readObject();

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        TxCFStatusWrapper txCFStatusWrapper = (TxCFStatusWrapper) cFStatusWrapper;
        SubscriberCfStatus txSubscriberCfStatus = txCFStatusWrapper.getTxSubscriberCfStatus();
        subscriberCfStatusImpl = (SubscriberCfStatusImpl) txSubscriberCfStatus;
        int encode = subscriberCfStatusImpl.encode();

        out.writeInt(encode);
        out.writeObject(forwardedToNumberWrapper);

    }

}
