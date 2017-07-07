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

package pl.ovoo.ss7.wrapper.cap.tx.args.cap1.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.asn.BitSetStrictLength;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.LocationNumber;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import org.mobicents.protocols.ss7.map.api.primitives.DiameterIdentity;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.LAIFixedLength;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.EUtranCgi;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.GeodeticInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.GeographicalInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformationEPS;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationNumberMap;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.TAId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.UserCSGInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.CSGId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.LSAIdentity;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap1.TxCap1InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.tx.args.TxMAPLocationInformationWrapper;

public class TxCap1InitialDPArgWrapperTest extends WrapperBaseTest {

    TxCap1InitialDPArgWrapper txCap1InitialDPArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCap1InitialDPArgWrapper = new TxCap1InitialDPArgWrapper();

        CalledPartyBCDNumber calledPartyBCDNumber = capFactory.createCalledPartyBCDNumber(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "0048677287634");
        CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(
                calledPartyBCDNumber);
        txCap1InitialDPArgWrapper.setCalledPartyBCDNumber(calledPartyBCDNumberWrapper);

        final CallReferenceNumber callReferenceNumber = mapParameterFactory
                .createCallReferenceNumber(new byte[] { 64 });
        CallReferenceNumberWrapper callReferenceNumberWrapper = new TxCallReferenceNumberWrapper(callReferenceNumber);
        txCap1InitialDPArgWrapper.setCallReferenceNumber(callReferenceNumberWrapper);

        final int serviceCode = BearerServiceCodeValue.allDataCDS_Services.getCode();
        final BearerServiceCode bearerServiceCode = mapParameterFactory.createBearerServiceCode(serviceCode);
        final ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(bearerServiceCode.getBearerServiceCodeValue());
        final ExtBasicServiceCode extBasicServiceCode = mapParameterFactory
                .createExtBasicServiceCode(extBearerServiceCode);
        txCap1InitialDPArgWrapper.setTxExtBasicServiceCode(extBasicServiceCode);

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
        MAPLocationInformationWrapper mapLocationInformationWrapper = new TxMAPLocationInformationWrapper(
                locationInformation);
        txCap1InitialDPArgWrapper.setLocationInformation(mapLocationInformationWrapper);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap1InitialDPArgWrapper);
        TxCap1InitialDPArgWrapper tx = (TxCap1InitialDPArgWrapper) deserializeFromFile();

        assertTrue(txCap1InitialDPArgWrapper.getCalledPartyBCDNumber().getNumberingPlan().getValue() == tx
                .getCalledPartyBCDNumber().getNumberingPlan().getValue());
        assertTrue(txCap1InitialDPArgWrapper.getCalledPartyBCDNumber().getAddress()
                .equals(tx.getCalledPartyBCDNumber().getAddress()));

        assertTrue(txCap1InitialDPArgWrapper.getCallReferenceNumber().getData()[0] == tx.getCallReferenceNumber()
                .getData()[0]);

        assertTrue(txCap1InitialDPArgWrapper.getExtBasicServiceCode().getExtBearerServiceCode().getData()[0] == tx
                .getExtBasicServiceCode().getExtBearerServiceCode().getData()[0]);

        assertTrue(txCap1InitialDPArgWrapper.getLocationInformation().getVlrNumber().getAddress()
                .equals(tx.getLocationInformation().getVlrNumber().getAddress()));

    }

}
