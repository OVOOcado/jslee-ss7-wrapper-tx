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
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.asn.BitSetStrictLength;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.LocationNumber;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import org.mobicents.protocols.ss7.map.api.primitives.DiameterIdentity;
import org.mobicents.protocols.ss7.map.api.primitives.IMEI;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.LAIFixedLength;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.EUtranCgi;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.GPRSMSClass;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.GeodeticInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.GeographicalInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformationEPS;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformationGPRS;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationNumberMap;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.MNPInfoRes;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.MSClassmark2;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.MSNetworkCapability;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.MSRadioAccessCapability;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.NotReachableReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.NumberPortabilityStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.PSSubscriberState;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.PSSubscriberStateChoice;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RAIdentity;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RouteingNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberState;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberStateChoice;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.TAId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.UserCSGInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.CSGId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.LSAIdentity;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxMAPSubscriberInfoWrapperTest extends WrapperBaseTest {

    TxMAPSubscriberInfoWrapper txMAPSubscriberInfoWrapper;

    @Before
    public void setUp() throws Exception {

        GeographicalInformation geographicalInformation = mapParameterFactory.createGeographicalInformation(1, 2, 3);
        ISDNAddressString isdnaAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.national_significant_number, NumberingPlan.ISDN, "0048675987234");
        LocationNumber locationNumber = isupFactory.createLocationNumber();
        locationNumber.setAddress("0048765987234");
        LocationNumberMap locationNumberMap = mapParameterFactory.createLocationNumberMap(locationNumber);
        MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 100 },
                new byte[] { 64 });
        ArrayList<MAPPrivateExtension> mapPrivateExtensions = new ArrayList<MAPPrivateExtension>(1);
        mapPrivateExtensions.add(mapPrivateExtension);
        MAPExtensionContainer mapExtensionContainer = mapParameterFactory
                .createMAPExtensionContainer(mapPrivateExtensions, new byte[] { 32 });
        LSAIdentity lsaIdentity = mapParameterFactory.createLSAIdentity(new byte[] { 16 });
        ISDNAddressString isdnaAddressString2 = mapParameterFactory
                .createISDNAddressString(AddressNature.abbreviated_number, NumberingPlan.ISDN, "0048675937234");
        GeodeticInformation geodeticInformation = mapParameterFactory.createGeodeticInformation(new byte[] { 32 });
        EUtranCgi euTranCgi = mapParameterFactory.createEUtranCgi(new byte[] { 64 });
        TAId taId = mapParameterFactory.createTAId(new byte[] { 8 });
        DiameterIdentity diameterIdentity = mapParameterFactory.createDiameterIdentity(new byte[] { 4 });
        LocationInformationEPS locationInformationEPS = mapParameterFactory.createLocationInformationEPS(euTranCgi,
                taId, mapExtensionContainer, geographicalInformation, geodeticInformation, true, 2, diameterIdentity);
        CSGId csgId = mapParameterFactory.createCSGId(new BitSetStrictLength(4));
        final UserCSGInformation userCSGInformation = mapParameterFactory.createUserCSGInformation(csgId,
                mapExtensionContainer, 1, 2);
        final LAIFixedLength laiFixedLength = mapParameterFactory.createLAIFixedLength(new byte[] { 64 });
        final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI = mapParameterFactory
                .createCellGlobalIdOrServiceAreaIdOrLAI(laiFixedLength);
        final LocationInformation locationInformation = mapParameterFactory.createLocationInformation(1,
                geographicalInformation, isdnaAddressString, locationNumberMap, cellGlobalIdOrServiceAreaIdOrLAI,
                mapExtensionContainer, lsaIdentity, isdnaAddressString2, geodeticInformation, true, true,
                locationInformationEPS, userCSGInformation);
        SubscriberState subscriberState = mapParameterFactory.createSubscriberState(SubscriberStateChoice.camelBusy,
                NotReachableReason.msPurged);
        RAIdentity raIdentity = mapParameterFactory.createRAIdentity(new byte[] { 64 });
        LocationInformationGPRS locationInformationGPRS = mapParameterFactory.createLocationInformationGPRS(
                cellGlobalIdOrServiceAreaIdOrLAI, raIdentity, geographicalInformation, isdnaAddressString, lsaIdentity,
                mapExtensionContainer, true, geodeticInformation, true, 1);
        PSSubscriberState psSubscriberState = mapParameterFactory.createPSSubscriberState(
                PSSubscriberStateChoice.notProvidedFromSGSNorMME, NotReachableReason.msPurged, null);
        IMEI imei = mapParameterFactory.createIMEI("426987 48 521745 2");
        MSClassmark2 msClassmark2 = mapParameterFactory.createMSClassmark2(new byte[] { 32 });
        MSNetworkCapability msNetworkCapability = mapParameterFactory.createMSNetworkCapability(new byte[] { 16 });
        MSRadioAccessCapability msRadioAccessCapability = mapParameterFactory
                .createMSRadioAccessCapability(new byte[] { 8 });
        GPRSMSClass gprSMSClass = mapParameterFactory.createGPRSMSClass(msNetworkCapability, msRadioAccessCapability);
        RouteingNumber routeingNumber = mapParameterFactory.createRouteingNumber("9272372372173295239612");
        IMSI imsi = mapParameterFactory.createIMSI("26022678678987");
        MNPInfoRes mnpInfoRes = mapParameterFactory.createMNPInfoRes(routeingNumber, imsi, isdnaAddressString,
                NumberPortabilityStatus.foreignNumberPortedIn, mapExtensionContainer);
        SubscriberInfo subscriberInfo = mapParameterFactory.createSubscriberInfo(locationInformation, subscriberState,
                mapExtensionContainer, locationInformationGPRS, psSubscriberState, imei, msClassmark2, gprSMSClass,
                mnpInfoRes);

        txMAPSubscriberInfoWrapper = new TxMAPSubscriberInfoWrapper(subscriberInfo);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPSubscriberInfoWrapper);
        TxMAPSubscriberInfoWrapper tx = (TxMAPSubscriberInfoWrapper) deserializeFromFile();

        assertTrue(txMAPSubscriberInfoWrapper.getTxSubscriberInfo().getLocationInformation().getVlrNumber().getAddress()
                .equals(tx.getTxSubscriberInfo().getLocationInformation().getVlrNumber().getAddress()));
        assertTrue(txMAPSubscriberInfoWrapper.getTxSubscriberInfo().getExtensionContainer().getPcsExtensions()[0] == tx
                .getTxSubscriberInfo().getExtensionContainer().getPcsExtensions()[0]);

    }

}
