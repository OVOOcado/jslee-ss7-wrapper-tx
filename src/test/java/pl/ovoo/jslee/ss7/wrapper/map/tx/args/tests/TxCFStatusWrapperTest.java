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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxCFStatusWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCFStatusWrapperTest extends WrapperBaseTest {

    TxCFStatusWrapper txCFStatusWrapper;

    @Before
    public void setUp() throws Exception {

        SubscriberCfStatus subscriberCfStatus = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);

        txCFStatusWrapper = new TxCFStatusWrapper(subscriberCfStatus);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txCFStatusWrapper);
        TxCFStatusWrapper tx = (TxCFStatusWrapper) deserializeFromFile();

        assertTrue(txCFStatusWrapper.getActive() == tx.getActive());
        assertTrue(txCFStatusWrapper.getProvided() == tx.getProvided());
        assertTrue(txCFStatusWrapper.getQuiescent() == tx.getQuiescent());
        assertTrue(txCFStatusWrapper.getRegistered() == tx.getRegistered());

        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusActivationIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusActivationIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusProvisionIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusProvisionIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusRegisterIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusRegisterIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusQuiescentIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusQuiescentIndicator()));

    }

}
