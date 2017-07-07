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
