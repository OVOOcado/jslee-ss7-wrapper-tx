package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InbandInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageIDText;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.InformationToSendWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInformationToSendWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxPlayAnnouncementArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxPlayAnnouncementArgWrapperTest extends WrapperBaseTest {

    TxPlayAnnouncementArgWrapper txPlayAnnouncementArgWrapper;

    @Before
    public void setUp() throws Exception {

        txPlayAnnouncementArgWrapper = new TxPlayAnnouncementArgWrapper();

        final MessageIDText messageIDText = capFactory.createMessageIDText("message", new byte[] { 32 });
        final MessageID messageID = capFactory.createMessageID(messageIDText);
        final InbandInfo inbandInfo = capFactory.createInbandInfo(messageID, 1, 2, 3);
        final InformationToSend informationToSend = capFactory.createInformationToSend(inbandInfo);
        InformationToSendWrapper informationToSendWrapper = new TxInformationToSendWrapper(informationToSend);
        txPlayAnnouncementArgWrapper.setInformationToSend(informationToSendWrapper);

        txPlayAnnouncementArgWrapper.setRequestAnnouncementComplete(new Boolean(true));
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txPlayAnnouncementArgWrapper);
        TxPlayAnnouncementArgWrapper tx = (TxPlayAnnouncementArgWrapper) deserializeFromFile();

        assertTrue(txPlayAnnouncementArgWrapper.getTxInformationToSend().getInbandInfo().getMessageID().getText()
                .getMessageContent()
                .equals(tx.getTxInformationToSend().getInbandInfo().getMessageID().getText().getMessageContent()));
        assertTrue(tx.getTxRequestAnnouncementComplete().booleanValue());

    }

}
