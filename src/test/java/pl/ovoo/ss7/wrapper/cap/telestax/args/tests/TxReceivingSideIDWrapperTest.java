package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReceivingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxReceivingSideIDWrapperTest extends WrapperBaseTest {

    TxReceivingSideIDWrapper txReceivingSideIDWrapper;

    @Before
    public void setUp() throws Exception {

        final ReceivingSideID receivingSideID = capFactory.createReceivingSideID(LegType.leg2);
        txReceivingSideIDWrapper = new TxReceivingSideIDWrapper(receivingSideID);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txReceivingSideIDWrapper);
        TxReceivingSideIDWrapper tx = (TxReceivingSideIDWrapper) deserializeFromFile();

        assertTrue(txReceivingSideIDWrapper.getTxReceivingSideID().getReceivingSideID().getCode() == tx
                .getTxReceivingSideID().getReceivingSideID().getCode());
    }

}
