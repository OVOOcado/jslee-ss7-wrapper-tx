package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
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
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPForwardingOptionsWrapper;

public class TxMAPForwardingOptionsWrapperTest extends WrapperBaseTest {

    TxMAPForwardingOptionsWrapper txMAPForwardingOptionsWrapper;

    @Before
    public void setUp() throws Exception {

        ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(true, true, true,
                ExtForwOptionsForwardingReason.msBusy);
        txMAPForwardingOptionsWrapper = new TxMAPForwardingOptionsWrapper(extForwOptions);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMAPForwardingOptionsWrapper);
        TxMAPForwardingOptionsWrapper tx = (TxMAPForwardingOptionsWrapper) deserializeFromFile();

        assertTrue(
                txMAPForwardingOptionsWrapper.getForwardingReason().getValue() == tx.getForwardingReason().getValue());
        assertTrue(txMAPForwardingOptionsWrapper.getTxExtForwOptions().getExtForwOptionsForwardingReason()
                .getCode() == tx.getTxExtForwOptions().getExtForwOptionsForwardingReason().getCode());

    }

}
