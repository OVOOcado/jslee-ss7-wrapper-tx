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
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCFInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSubscriberCFInfoWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxSubscriberCFInfoWrapperTest extends WrapperBaseTest {

    TxSubscriberCFInfoWrapper txSubscriberCFInfoWrapper;

    @Before
    public void setUp() throws Exception {

        AddressString cfAddressString1 = mapParameterFactory.createCfAddressString(AddressNature.abbreviated_number,
                NumberingPlan.data, "00609283124");
        AddressString cfAddressString2 = mapParameterFactory.createCfAddressString(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "00607356936");
        AddressString cfAddressString3 = mapParameterFactory
                .createCfAddressString(AddressNature.network_specific_number, NumberingPlan.national, "00720567834");
        AddressString cfAddressString4 = mapParameterFactory.createCfAddressString(AddressNature.reserved,
                NumberingPlan.private_plan, "00567893456");
        AddressString cfAddressString5 = mapParameterFactory.createCfAddressString(AddressNature.subscriber_number,
                NumberingPlan.reserved, "00678987345");
        AddressString cfAddressString6 = mapParameterFactory.createCfAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "00698734567");

        SubscriberCfStatus subscriberCfStatus1 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus2 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.PROVIDED);
        SubscriberCfStatus subscriberCfStatus3 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus4 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus5 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus6 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.PROVIDED);

        SubscriberCFInfo subscriberCFInfo = mapParameterFactory.createSubscriberCFInfo(cfAddressString1,
                subscriberCfStatus1, cfAddressString2, subscriberCfStatus2, cfAddressString3, subscriberCfStatus3,
                cfAddressString4, subscriberCfStatus4, cfAddressString5, subscriberCfStatus5, cfAddressString6,
                subscriberCfStatus6);

        txSubscriberCFInfoWrapper = new TxSubscriberCFInfoWrapper(subscriberCFInfo);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txSubscriberCFInfoWrapper);
        TxSubscriberCFInfoWrapper tx = (TxSubscriberCFInfoWrapper) deserializeFromFile();

        assertTrue(txSubscriberCFInfoWrapper.getCFNoReplyTS10().getCFStatus().getActive() == tx.getCFNoReplyTS10()
                .getCFStatus().getActive());
        assertTrue(txSubscriberCFInfoWrapper.getCFNoReplyTS10().getCFStatus().getProvided() == tx.getCFNoReplyTS10()
                .getCFStatus().getProvided());
        assertTrue(txSubscriberCFInfoWrapper.getCFNoReplyTS10().getCFStatus().getQuiescent() == tx.getCFNoReplyTS10()
                .getCFStatus().getQuiescent());
        assertTrue(txSubscriberCFInfoWrapper.getCFNoReplyTS10().getCFStatus().getRegistered() == tx.getCFNoReplyTS10()
                .getCFStatus().getRegistered());

        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberBusyTS10().getCFStatus().getActive() == tx
                .getCFSubscriberBusyTS10().getCFStatus().getActive());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberBusyTS10().getCFStatus().getProvided() == tx
                .getCFSubscriberBusyTS10().getCFStatus().getProvided());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberBusyTS10().getCFStatus().getQuiescent() == tx
                .getCFSubscriberBusyTS10().getCFStatus().getQuiescent());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberBusyTS10().getCFStatus().getRegistered() == tx
                .getCFSubscriberBusyTS10().getCFStatus().getRegistered());

        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getActive() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getActive());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getProvided() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getProvided());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getQuiescent() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getQuiescent());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getRegistered() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getRegistered());

        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getActive() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getActive());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getProvided() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getProvided());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getQuiescent() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getQuiescent());
        assertTrue(txSubscriberCFInfoWrapper.getCFSubscriberNotReachableTS10().getCFStatus().getRegistered() == tx
                .getCFSubscriberNotReachableTS10().getCFStatus().getRegistered());
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getBs30CfbStatus().getCfStatusRegisterIndicator()
                .equals(tx.getTxSubscriberCFInfo().getBs30CfbStatus().getCfStatusRegisterIndicator()));
        assertTrue(
                txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getTs10CfrncStatus().getCfStatusProvisionIndicator()
                        .equals(tx.getTxSubscriberCFInfo().getTs10CfrncStatus().getCfStatusProvisionIndicator()));
        assertTrue(
                txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getTs10CfrncStatus().getCfStatusActivationIndicator()
                        .equals(tx.getTxSubscriberCFInfo().getTs10CfrncStatus().getCfStatusActivationIndicator()));
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getTs10CfbNumber().getAddressNature()
                .getIndicator() == tx.getTxSubscriberCFInfo().getTs10CfbNumber().getAddressNature().getIndicator());
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getBs30CfbNumber().getAddress()
                .equals(tx.getTxSubscriberCFInfo().getBs30CfbNumber().getAddress()));
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getBs30CfbNumber().getAddressNature()
                .getIndicator() == tx.getTxSubscriberCFInfo().getBs30CfbNumber().getAddressNature().getIndicator());
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getBs30CfbNumber().getNumberingPlan()
                .getIndicator() == tx.getTxSubscriberCFInfo().getBs30CfbNumber().getNumberingPlan().getIndicator());

        assertTrue(
                txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getBs30CfrncStatus().getCfStatusProvisionIndicator()
                        .equals(tx.getTxSubscriberCFInfo().getBs30CfrncStatus().getCfStatusProvisionIndicator()));
        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getTs10CfbStatus().getCfStatusQuiescentIndicator()
                .equals(tx.getTxSubscriberCFInfo().getTs10CfbStatus().getCfStatusQuiescentIndicator()));

        assertTrue(txSubscriberCFInfoWrapper.getTxSubscriberCFInfo().getTs10CfbNumber().getAddress()
                .equals(tx.getTxSubscriberCFInfo().getTs10CfbNumber().getAddress()));

    }
}
