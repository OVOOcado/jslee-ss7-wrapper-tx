package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InbandInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageIDText;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInbandInfoWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxInbandInfoWrapperTest extends WrapperBaseTest {

    TxInbandInfoWrapper txInbandInfoWrapper;

    @Before
    public void setUp() throws Exception {

        MessageIDText messageIDText = capFactory.createMessageIDText("exampleString", new byte[] { 64 });
        MessageID messageID = capFactory.createMessageID(messageIDText);
        InbandInfo inbandInfo = capFactory.createInbandInfo(messageID, new Integer(1), new Integer(2), new Integer(3));
        txInbandInfoWrapper = new TxInbandInfoWrapper(inbandInfo);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInbandInfoWrapper);
        TxInbandInfoWrapper tx = (TxInbandInfoWrapper) deserializeFromFile();

        assertTrue(txInbandInfoWrapper.getTxInbandInfo().getMessageID().getText().getMessageContent()
                .equals(tx.getTxInbandInfo().getMessageID().getText().getMessageContent()));
        assertTrue(txInbandInfoWrapper.getTxInbandInfo().getMessageID().getText().getAttributes()[0] == tx
                .getTxInbandInfo().getMessageID().getText().getAttributes()[0]);

    }

}
