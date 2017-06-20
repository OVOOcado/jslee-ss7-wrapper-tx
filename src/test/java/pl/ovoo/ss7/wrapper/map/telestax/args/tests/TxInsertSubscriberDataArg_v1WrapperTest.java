package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.FTNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNSubaddressString;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;
import org.mobicents.protocols.ss7.map.service.mobility.subscriberManagement.InsertSubscriberDataRequestImpl;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSS_InformationWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxInsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSS_InformationWrapper;

public class TxInsertSubscriberDataArg_v1WrapperTest extends WrapperBaseTest {

    TxInsertSubscriberDataArg_v1Wrapper txInsertSubscriberDataArg_v1Wrapper;

    @Before
    public void setUp() throws Exception {

        InsertSubscriberDataRequest insertSubscriberDataRequest = new InsertSubscriberDataRequestImpl(123456789);
        txInsertSubscriberDataArg_v1Wrapper = new TxInsertSubscriberDataArg_v1Wrapper(insertSubscriberDataRequest);

        IMSI imsi = mapParameterFactory.createIMSI("26055678987234");
        IMSIAddressWrapper imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txInsertSubscriberDataArg_v1Wrapper.setImsi(imsiAddressWrapper);

        FTNAddressString ftnAddressString = mapParameterFactory.createFTNAddressString(
                AddressNature.national_significant_number, NumberingPlan.national, "0048214248124");
        MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 100 },
                new byte[] { 64 });
        ArrayList<MAPPrivateExtension> mapPrivateExtensions = new ArrayList<MAPPrivateExtension>(1);
        mapPrivateExtensions.add(mapPrivateExtension);
        MAPExtensionContainer mapExtensionContainer = mapParameterFactory
                .createMAPExtensionContainer(mapPrivateExtensions, new byte[] { 32 });
        ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(true, true, true,
                ExtForwOptionsForwardingReason.msBusy);
        ISDNSubaddressString isdnSubaddressString = mapParameterFactory.createISDNSubaddressString(new byte[] { 32 });
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.international_number, NumberingPlan.ISDN, "0048766243123");
        ExtSSStatus extSSStatus = mapParameterFactory.createExtSSStatus(true, false, true, false);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(BearerServiceCodeValue.allAlternateSpeech_DataCDS);
        ExtBasicServiceCode extBasicServiceCode = mapParameterFactory.createExtBasicServiceCode(extBearerServiceCode);
        ExtForwFeature extForwFeature = mapParameterFactory.createExtForwFeature(extBasicServiceCode, extSSStatus,
                isdnAddressString, isdnSubaddressString, extForwOptions, 1, mapExtensionContainer, ftnAddressString);
        ArrayList<ExtForwFeature> extForwFeatures = new ArrayList<ExtForwFeature>(1);
        extForwFeatures.add(extForwFeature);
        org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode ssCode = mapParameterFactory
                .createSSCode(SupplementaryCodeValue.allCallCompletionSS);
        ExtForwInfo extForwInfo = mapParameterFactory.createExtForwInfo(ssCode, extForwFeatures, mapExtensionContainer);
        ExtSSInfo extSSInfo = mapParameterFactory.createExtSSInfo(extForwInfo);
        MAPSS_InformationWrapper mapss_Informations = new TxMAPSS_InformationWrapper(extSSInfo);
        MAPSS_InformationWrapper[] mapss_InformationWrappers = new MAPSS_InformationWrapper[1];
        mapss_InformationWrappers[0] = mapss_Informations;

        txInsertSubscriberDataArg_v1Wrapper.setProvisionedSS(mapss_InformationWrappers);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInsertSubscriberDataArg_v1Wrapper);
        TxInsertSubscriberDataArg_v1Wrapper tx = (TxInsertSubscriberDataArg_v1Wrapper) deserializeFromFile();

        assertTrue(txInsertSubscriberDataArg_v1Wrapper.getTxImsi().getData().equals(tx.getTxImsi().getData()));
        assertTrue(txInsertSubscriberDataArg_v1Wrapper.getTxProvisionedSS()[0].getForwardingInfo().getSsCode()
                .getSupplementaryCodeValue().getCode() == tx.getTxProvisionedSS()[0].getForwardingInfo().getSsCode()
                        .getSupplementaryCodeValue().getCode());

    }

}
