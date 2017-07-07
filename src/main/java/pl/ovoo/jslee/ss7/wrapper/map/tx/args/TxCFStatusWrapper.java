/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.ss7.wrapper.map.tx.args;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
