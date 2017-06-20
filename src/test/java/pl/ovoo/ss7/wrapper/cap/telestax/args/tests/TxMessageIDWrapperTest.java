package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageIDText;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxMessageIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxMessageIDWrapperTest extends WrapperBaseTest {

    TxMessageIDWrapper txMessageIDWrapper;

    @Before
    public void setUp() throws Exception {

        MessageIDText messageIDText = capFactory.createMessageIDText("message", new byte[] { 32 });
        MessageID messageID = capFactory.createMessageID(messageIDText);
        txMessageIDWrapper = new TxMessageIDWrapper(messageID);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMessageIDWrapper);
        TxMessageIDWrapper tx = (TxMessageIDWrapper) deserializeFromFile();

        assertTrue(txMessageIDWrapper.getTxMessageID().getText().getMessageContent()
                .equals(tx.getTxMessageID().getText().getMessageContent()));
        assertTrue(txMessageIDWrapper.getTxMessageID().getText().getAttributes()[0] == tx.getTxMessageID().getText()
                .getAttributes()[0]);
    }

}
