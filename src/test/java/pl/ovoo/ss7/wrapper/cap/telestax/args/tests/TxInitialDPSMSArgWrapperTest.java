package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.asn.BitSetStrictLength;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSAddressString;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.LocationNumber;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import org.mobicents.protocols.ss7.map.api.primitives.DiameterIdentity;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
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
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.CSGId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.LSAIdentity;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInitialDPSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxSMSAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPLocationInformationWrapper;

public class TxInitialDPSMSArgWrapperTest extends WrapperBaseTest {

    TxInitialDPSMSArgWrapper txInitialDPSMSArgWrapper;

    @Before
    public void setUp() throws Exception {

        txInitialDPSMSArgWrapper = new TxInitialDPSMSArgWrapper();

        SMSAddressString smsAddressString = capFactory.createSMSAddressString(AddressNature.national_significant_number,
                NumberingPlan.land_mobile, "0048678987654");
        AddressStringWrapper addressStringWrapper = new TxSMSAddressStringWrapperImpl(smsAddressString);
        txInitialDPSMSArgWrapper.setCallingPartyNumber(addressStringWrapper);

        CalledPartyBCDNumber calledPartyBCDNumber = capFactory.createCalledPartyBCDNumber(
                AddressNature.network_specific_number, NumberingPlan.private_plan, "0048678987634");
        CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(
                calledPartyBCDNumber);
        txInitialDPSMSArgWrapper.setDestinationSubscriberNumber(calledPartyBCDNumberWrapper);

        IMSI imsi = mapParameterFactory.createIMSI("Imsi");
        IMSIAddressWrapper imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txInitialDPSMSArgWrapper.setIMSI(imsiAddressWrapper);

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
        txInitialDPSMSArgWrapper.setLocationInformationMSC(mapLocationInformationWrapper);

        ISDNAddressStringWrapper isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(isdnaAddressString);
        txInitialDPSMSArgWrapper.setMSCAddress(isdnAddressStringWrapper);

        txInitialDPSMSArgWrapper.setServiceKey(32);

        txInitialDPSMSArgWrapper.setSMSCAddress(isdnAddressStringWrapper);

        final CallReferenceNumber callReferenceNumber = mapParameterFactory
                .createCallReferenceNumber(new byte[] { 127 });
        CallReferenceNumberWrapper callReferenceNumberWrapper = new TxCallReferenceNumberWrapper(callReferenceNumber);
        txInitialDPSMSArgWrapper.setSmsReferenceNumber(callReferenceNumberWrapper);

        final org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone createTimeAndTimezone = capFactory
                .createTimeAndTimezone(2017, 5, 29, 13, 29, 25, 10);
        TimeAndTimezoneWrapper timeAndTimezone = new TxTimeAndTimezoneWrapper(createTimeAndTimezone);
        txInitialDPSMSArgWrapper.setTimeAndTimezone(timeAndTimezone);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInitialDPSMSArgWrapper);
        TxInitialDPSMSArgWrapper tx = (TxInitialDPSMSArgWrapper) deserializeFromFile();

        assertTrue(txInitialDPSMSArgWrapper.getCallingPartyNumber().getAddress()
                .equals(tx.getCallingPartyNumber().getAddress()));
        assertTrue(txInitialDPSMSArgWrapper.getCallingPartyNumber().getNature()
                .equals(tx.getCallingPartyNumber().getNature()));

        assertTrue(txInitialDPSMSArgWrapper.getTxDestinationSubscriberNumber().getNumberingPlan().getIndicator() == tx
                .getTxDestinationSubscriberNumber().getNumberingPlan().getIndicator());
        assertTrue(txInitialDPSMSArgWrapper.getTxDestinationSubscriberNumber().getAddressNature().getIndicator() == tx
                .getTxDestinationSubscriberNumber().getAddressNature().getIndicator());

        assertTrue(txInitialDPSMSArgWrapper.getIMSI().getAddress().equals(tx.getIMSI().getAddress()));

        assertTrue(txInitialDPSMSArgWrapper.getTxLocationInformationMSC().getExtensionContainer()
                .getPcsExtensions()[0] == tx.getTxLocationInformationMSC().getExtensionContainer()
                        .getPcsExtensions()[0]);
        assertTrue(txInitialDPSMSArgWrapper.getTxLocationInformationMSC().getGeodeticInformation().getData()[0] == tx
                .getTxLocationInformationMSC().getGeodeticInformation().getData()[0]);

        assertTrue(txInitialDPSMSArgWrapper.getTxMscAddress().getAddressNature()
                .equals(tx.getTxMscAddress().getAddressNature()));

        assertTrue(txInitialDPSMSArgWrapper.getServiceKey() == tx.getServiceKey());

        assertTrue(txInitialDPSMSArgWrapper.getSMSCAddress().getAddress().equals(tx.getSMSCAddress().getAddress()));

        assertTrue(txInitialDPSMSArgWrapper.getTxSmsReferenceNumber().getData()[0] == tx.getTxSmsReferenceNumber()
                .getData()[0]);

        assertTrue(txInitialDPSMSArgWrapper.getTxTimeAndTimezone().getYear() == tx.getTxTimeAndTimezone().getYear());

    }

}
