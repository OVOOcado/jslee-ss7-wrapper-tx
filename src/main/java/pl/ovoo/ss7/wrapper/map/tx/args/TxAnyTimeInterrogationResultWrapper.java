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

package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(TxAnyTimeInterrogationResultWrapper.class);

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
            logger.info(e);
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
            logger.info(e);
            e.printStackTrace();
        }
        byte[] byteArray = asnOs.toByteArray();
        asnOs.close();
        out.writeObject(byteArray);
        out.writeObject(subscriberInfoWrapper);
    }

}
