package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.FTNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNSubaddressString;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPCallForwardingDataWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPExt_ForwFeatureWrapper;

public class TxMAPCallForwardingDataWrapperTest extends WrapperBaseTest {

    TxMAPCallForwardingDataWrapper txMAPCallForwardingDataWrapper;

    @Before
    public void setUp() throws Exception {

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
        MAPExt_ForwFeatureWrapper mapExt_ForwFeatureWrapper = new TxMAPExt_ForwFeatureWrapper(extForwFeature);
        MAPExt_ForwFeatureWrapper[] mapExt_ForwFeatureWrappers = new MAPExt_ForwFeatureWrapper[1];
        mapExt_ForwFeatureWrappers[0] = mapExt_ForwFeatureWrapper;

        txMAPCallForwardingDataWrapper = new TxMAPCallForwardingDataWrapper(mapExt_ForwFeatureWrappers);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPCallForwardingDataWrapper);
        TxMAPCallForwardingDataWrapper tx = (TxMAPCallForwardingDataWrapper) deserializeFromFile();

        assertTrue(txMAPCallForwardingDataWrapper.getForwardingFeatureList()[0].getForwardedToNumber().getAddress()
                .equals(tx.getForwardingFeatureList()[0].getForwardedToNumber().getAddress()));
        assertTrue(txMAPCallForwardingDataWrapper.getForwardingFeatureList()[0]
                .getCFStatus()[0] == tx.getForwardingFeatureList()[0].getCFStatus()[0]);

    }

}
