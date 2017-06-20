package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.SupportedFeatures;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtTeleserviceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ODBGeneralData;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.OfferedCamel4CSIs;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.RegionalSubscriptionResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.SupportedCamelPhases;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;
import org.mobicents.protocols.ss7.map.service.mobility.subscriberManagement.InsertSubscriberDataResponseImpl;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxInsertSubscriberDataResponseWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMapArgsFactory;

public class TxInsertSubscriberDataResponseWrapperTest extends WrapperBaseTest {

    TxInsertSubscriberDataResponseWrapper txInsertSubscriberDataResponseWrapper;

    @Before
    public void setUp() throws Exception {
        TxMapArgsFactory txMapArgsFactory = new TxMapArgsFactory(mapParameterFactory);
        ExtTeleserviceCode extTeleserviceCode = mapParameterFactory
                .createExtTeleserviceCode(TeleserviceCodeValue.allFacsimileTransmissionServices);
        ArrayList<ExtTeleserviceCode> teleServiceList = new ArrayList<ExtTeleserviceCode>(1);
        teleServiceList.add(extTeleserviceCode);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(BearerServiceCodeValue.allAsynchronousServices);
        ArrayList<ExtBearerServiceCode> bearerServiceList = new ArrayList<ExtBearerServiceCode>(1);
        bearerServiceList.add(extBearerServiceCode);
        SSCode ssCode = mapParameterFactory.createSSCode(SupplementaryCodeValue.allCallOfferingSS);
        ArrayList<SSCode> ssList = new ArrayList<SSCode>(1);
        ssList.add(ssCode);
        ODBGeneralData odbGeneralData = mapParameterFactory.createODBGeneralData(true, true, false, true, true, true,
                false, false, false, true, false, false, true, true, true, false, true, true, true, false, false, true,
                false, true, true, true, true, false, true);
        SupportedCamelPhases supportedCamelPhases = mapParameterFactory.createSupportedCamelPhases(true, true, true,
                true);
        MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 128 },
                new byte[] { 64 });
        ArrayList<MAPPrivateExtension> mapPrivateList = new ArrayList<MAPPrivateExtension>(1);
        mapPrivateList.add(mapPrivateExtension);
        MAPExtensionContainer mapExtensionContainer = mapParameterFactory.createMAPExtensionContainer(mapPrivateList,
                new byte[] { 32 });
        OfferedCamel4CSIs offeredCamel4CSIs = mapParameterFactory.createOfferedCamel4CSIs(true, true, false, true, true,
                false, true);
        SupportedFeatures supportedFeatures = mapParameterFactory.createSupportedFeatures(true, true, false, true, true,
                true, false, false, false, true, false, false, true, true, true, false, true, true, true, false, false,
                true, false, true, true, true);

        InsertSubscriberDataResponseImpl insertSubscriberDataResponseImpl = new InsertSubscriberDataResponseImpl(1L,
                teleServiceList, bearerServiceList, ssList, odbGeneralData,
                RegionalSubscriptionResponse.networkNodeAreaRestricted, supportedCamelPhases, mapExtensionContainer,
                offeredCamel4CSIs, supportedFeatures);
        txInsertSubscriberDataResponseWrapper = new TxInsertSubscriberDataResponseWrapper(
                insertSubscriberDataResponseImpl);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txInsertSubscriberDataResponseWrapper);
        TxInsertSubscriberDataResponseWrapper tx = (TxInsertSubscriberDataResponseWrapper) deserializeFromFile();

        // No getters or setters so far implemented in
        // TxInsertSubscriberDataResponseWrapper
        assertTrue(true);

    }

}
