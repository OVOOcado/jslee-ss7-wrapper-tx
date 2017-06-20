package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

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
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
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
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCFInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberState;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberStateChoice;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.TAId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.UserCSGInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.CSGId;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.LSAIdentity;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SubscriberCFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxAnyTimeInterrogationResultWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSubscriberCFInfoWrapper;

public class TxAnyTimeInterrogationResultWrapperTest extends WrapperBaseTest {

    TxAnyTimeInterrogationResultWrapper txAnyTimeInterrogationResultWrapper;

    @Before
    public void setUp() throws Exception {

        AddressString cfAddressString1 = mapParameterFactory.createCfAddressString(AddressNature.abbreviated_number,
                NumberingPlan.data, "609283124");
        AddressString cfAddressString2 = mapParameterFactory.createCfAddressString(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "607356936");
        AddressString cfAddressString3 = mapParameterFactory
                .createCfAddressString(AddressNature.network_specific_number, NumberingPlan.national, "720567834");
        AddressString cfAddressString4 = mapParameterFactory.createCfAddressString(AddressNature.reserved,
                NumberingPlan.private_plan, "567893456");
        AddressString cfAddressString5 = mapParameterFactory.createCfAddressString(AddressNature.subscriber_number,
                NumberingPlan.reserved, "678987345");
        AddressString cfAddressString6 = mapParameterFactory.createCfAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "698734567");

        SubscriberCfStatus subscriberCfStatus1 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus2 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus3 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus4 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.PROVIDED);
        SubscriberCfStatus subscriberCfStatus5 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        SubscriberCfStatus subscriberCfStatus6 = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);

        SubscriberCFInfo subscriberCFInfo = mapParameterFactory.createSubscriberCFInfo(cfAddressString1,
                subscriberCfStatus1, cfAddressString2, subscriberCfStatus2, cfAddressString3, subscriberCfStatus3,
                cfAddressString4, subscriberCfStatus4, cfAddressString5, subscriberCfStatus5, cfAddressString6,
                subscriberCfStatus6);

        SubscriberCFInfoWrapper txSubscriberCFInfoWrapper = new TxSubscriberCFInfoWrapper(subscriberCFInfo);

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
        MAPSubscriberInfoWrapper txMAPSubscriberInfoWrapper = new TxMAPSubscriberInfoWrapper(subscriberInfo);

        txAnyTimeInterrogationResultWrapper = new TxAnyTimeInterrogationResultWrapper(txSubscriberCFInfoWrapper,
                txMAPSubscriberInfoWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txAnyTimeInterrogationResultWrapper);
        TxAnyTimeInterrogationResultWrapper tx = (TxAnyTimeInterrogationResultWrapper) deserializeFromFile();

        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberInfo().getLocationInformation().getVlrNumber()
                .getAddress().equals(tx.getSubscriberInfo().getLocationInformation().getVlrNumber().getAddress()));

        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus()
                .getActive() == tx.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus().getActive());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus()
                .getProvided() == tx.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus().getProvided());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus()
                .getQuiescent() == tx.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus().getQuiescent());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus()
                .getRegistered() == tx.getSubscriberCFInfo().getCFNoReplyTS10().getCFStatus().getRegistered());

        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus()
                .getActive() == tx.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus().getActive());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus()
                .getProvided() == tx.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus().getProvided());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus()
                .getQuiescent() == tx.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus().getQuiescent());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus()
                .getRegistered() == tx.getSubscriberCFInfo().getCFSubscriberBusyTS10().getCFStatus().getRegistered());

        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                .getCFStatus()
                .getActive() == tx.getSubscriberCFInfo().getCFSubscriberNotReachableTS10().getCFStatus().getActive());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                .getCFStatus().getProvided() == tx.getSubscriberCFInfo().getCFSubscriberNotReachableTS10().getCFStatus()
                        .getProvided());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                .getCFStatus().getQuiescent() == tx.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                        .getCFStatus().getQuiescent());
        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                .getCFStatus().getRegistered() == tx.getSubscriberCFInfo().getCFSubscriberNotReachableTS10()
                        .getCFStatus().getRegistered());

        assertTrue(txAnyTimeInterrogationResultWrapper.getSubscriberCFInfo().getCFSubscriberBusyTS10()
                .getForwardedToNumber().getNature().getValue() == tx.getSubscriberCFInfo().getCFSubscriberBusyTS10()
                        .getForwardedToNumber().getNature().getValue());

    }

}
