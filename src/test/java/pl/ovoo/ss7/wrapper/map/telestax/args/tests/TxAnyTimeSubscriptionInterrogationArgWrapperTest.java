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

package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberIdentityWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxAnyTimeSubscriptionInterrogationArgWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSubscriberIdentityWrapper;

public class TxAnyTimeSubscriptionInterrogationArgWrapperTest extends WrapperBaseTest {

    TxAnyTimeSubscriptionInterrogationArgWrapper txAnyTimeSubscriptionInterrogationArgWrapper;

    @Before
    public void setUp() throws Exception {

        txAnyTimeSubscriptionInterrogationArgWrapper = new TxAnyTimeSubscriptionInterrogationArgWrapper();

        final ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.international_number, NumberingPlan.ISDN, "0048765678456");
        AddressStringWrapper addressStringWrapper = new TxISDNAddressStringWrapperImpl(isdnAddressString);
        txAnyTimeSubscriptionInterrogationArgWrapper.setGsmSCF_Address(addressStringWrapper);

        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "0048678987345");
        SubscriberIdentity subscriberIdentity = mapParameterFactory.createSubscriberIdentity(addressString);
        MAPSubscriberIdentityWrapper maIdentityWrapper = new TxMAPSubscriberIdentityWrapper(subscriberIdentity);
        txAnyTimeSubscriptionInterrogationArgWrapper.setSubscriberIdentity(maIdentityWrapper);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txAnyTimeSubscriptionInterrogationArgWrapper);
        TxAnyTimeSubscriptionInterrogationArgWrapper tx = (TxAnyTimeSubscriptionInterrogationArgWrapper) deserializeFromFile();

        assertTrue(txAnyTimeSubscriptionInterrogationArgWrapper.getTxGsmScfAddress().getAddressNature()
                .getIndicator() == tx.getTxGsmScfAddress().getAddressNature().getIndicator());

        assertTrue(txAnyTimeSubscriptionInterrogationArgWrapper.getTxSubscriberIdentity().getMSISDN().getAddressNature()
                .getIndicator() == tx.getTxSubscriberIdentity().getMSISDN().getAddressNature().getIndicator());
        assertTrue(txAnyTimeSubscriptionInterrogationArgWrapper.getTxSubscriberIdentity().getMSISDN().getAddress()
                .equals(tx.getTxSubscriberIdentity().getMSISDN().getAddress()));
    }

}
