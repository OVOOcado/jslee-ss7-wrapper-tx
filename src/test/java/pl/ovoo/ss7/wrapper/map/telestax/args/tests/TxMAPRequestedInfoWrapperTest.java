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
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.DomainType;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPRequestedInfoWrapper;

public class TxMAPRequestedInfoWrapperTest extends WrapperBaseTest {

    TxMAPRequestedInfoWrapper txMAPRequestedInfoWrapper;

    @Before
    public void setUp() throws Exception {

        MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 100 },
                new byte[] { 64 });
        ArrayList<MAPPrivateExtension> mapPrivateExtensions = new ArrayList<MAPPrivateExtension>(1);
        mapPrivateExtensions.add(mapPrivateExtension);
        MAPExtensionContainer mapExtensionContainer = mapParameterFactory
                .createMAPExtensionContainer(mapPrivateExtensions, new byte[] { 32 });

        RequestedInfo requestedInfo = mapParameterFactory.createRequestedInfo(true, true, mapExtensionContainer, true,
                DomainType.csDomain, false, false, true);
        txMAPRequestedInfoWrapper = new TxMAPRequestedInfoWrapper(requestedInfo);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPRequestedInfoWrapper);
        TxMAPRequestedInfoWrapper tx = (TxMAPRequestedInfoWrapper) deserializeFromFile();

        assertTrue(txMAPRequestedInfoWrapper.getTxRequestedInfo().getExtensionContainer().getPcsExtensions()[0] == tx
                .getTxRequestedInfo().getExtensionContainer().getPcsExtensions()[0]);
        assertTrue(txMAPRequestedInfoWrapper.getTxRequestedInfo().getRequestedDomain().getType() == tx
                .getTxRequestedInfo().getRequestedDomain().getType());

    }

}
