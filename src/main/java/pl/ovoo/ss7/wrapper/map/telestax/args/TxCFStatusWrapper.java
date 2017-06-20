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

import pl.ovoo.ss7.wrapper.map.args.CFStatusWrapper;

/**
 * TxCFStatusWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxCFStatusWrapper implements CFStatusWrapper{

    private SubscriberCfStatus subscriberCfStatus;

    private SubscriberCfStatusImpl subscriberCfStatusImpl;

    public TxCFStatusWrapper() {
    }

    public TxCFStatusWrapper(final SubscriberCfStatus subscriberCfStatus) {
        this.subscriberCfStatus = subscriberCfStatus;
    }

    @Override
    public boolean hasActive() {
        return subscriberCfStatus.getCfStatusActivationIndicator() != null;
    }

    @Override
    public boolean hasProvided() {
        return subscriberCfStatus.getCfStatusProvisionIndicator() != null;
    }

    @Override
    public boolean hasQuiescent() {
        return subscriberCfStatus.getCfStatusQuiescentIndicator() != null;
    }

    @Override
    public boolean hasRegistered() {
        return subscriberCfStatus.getCfStatusRegisterIndicator() != null;
    }

    @Override
    public boolean getActive() {
        return subscriberCfStatus.getCfStatusActivationIndicator().equals(CfStatusActivationIndicator.ACTIVE);
    }

    @Override
    public boolean getProvided() {
        return subscriberCfStatus.getCfStatusProvisionIndicator().equals(CfStatusProvisionIndicator.PROVIDED);
    }

    @Override
    public boolean getQuiescent() {
        return subscriberCfStatus.getCfStatusQuiescentIndicator().equals(CfStatusQuiescentIndicator.QUIESCENT);
    }

    @Override
    public boolean getRegistered() {
        return subscriberCfStatus.getCfStatusRegisterIndicator().equals(CfStatusRegisterIndicator.REGISTERED);
    }

    public SubscriberCfStatus getTxSubscriberCfStatus() {
        return subscriberCfStatus;
    }

    @Override
    public String toString() {
        return "TxCFStatusWrapper [subscriberCfStatus=" + subscriberCfStatus + "]";
    }

    @Override
    public void readExternal(ObjectInput oin) throws IOException, ClassNotFoundException {
        subscriberCfStatusImpl = new SubscriberCfStatusImpl();
        this.subscriberCfStatusImpl.decode(oin.readInt());

        this.subscriberCfStatus = subscriberCfStatusImpl;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        this.subscriberCfStatusImpl = (SubscriberCfStatusImpl) subscriberCfStatus;
        out.writeInt(subscriberCfStatusImpl.encode());
    }

}
