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
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.CFStatusWrapper;
import pl.ovoo.ss7.wrapper.map.args.ForwardedToNumberWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCFStatusWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxForwardedToNumberWrapper;

public class TxCFInfoWrapperTest extends WrapperBaseTest {

    TxCFInfoWrapper txCFInfoWrapper;

    @Before
    public void setUp() throws Exception {

        SubscriberCfStatus subscriberCfStatus = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        AddressString addressString = mapParameterFactory.createAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "0048372612952");
        ForwardedToNumberWrapper forwardedToNumberWrapper = new TxForwardedToNumberWrapper(addressString);
        CFStatusWrapper cfStatusWrapper = new TxCFStatusWrapper(subscriberCfStatus);

        txCFInfoWrapper = new TxCFInfoWrapper(cfStatusWrapper, forwardedToNumberWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txCFInfoWrapper);
        TxCFInfoWrapper tx = (TxCFInfoWrapper) deserializeFromFile();

        assertTrue(txCFInfoWrapper.getCFStatus().getProvided() == tx.getCFStatus().getProvided());
        assertTrue(txCFInfoWrapper.getCFStatus().getQuiescent() == tx.getCFStatus().getQuiescent());
        assertTrue(txCFInfoWrapper.getCFStatus().getActive() == tx.getCFStatus().getActive());
        assertTrue(txCFInfoWrapper.getCFStatus().getRegistered() == tx.getCFStatus().getRegistered());

        assertTrue(txCFInfoWrapper.getForwardedToNumber().getAddress().equals(tx.getForwardedToNumber().getAddress()));
        assertTrue(txCFInfoWrapper.getForwardedToNumber().getNature().getValue() == tx.getForwardedToNumber()
                .getNature().getValue());
        assertTrue(txCFInfoWrapper.getForwardedToNumber().getNumberingPlan().getValue() == tx.getForwardedToNumber()
                .getNumberingPlan().getValue());

    }

}
