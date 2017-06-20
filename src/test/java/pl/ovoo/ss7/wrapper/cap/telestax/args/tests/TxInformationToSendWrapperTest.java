package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.Tone;
import org.mobicents.protocols.ss7.cap.service.circuitSwitchedCall.primitive.ToneImpl;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInformationToSendWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxInformationToSendWrapperTest extends WrapperBaseTest {

    TxInformationToSendWrapper txInformationToSendWrapper;

    @Before
    public void setUp() throws Exception {

        Tone tone = capFactory.createTone(ToneImpl._ID_toneID, ToneImpl._ID_duration);
        InformationToSend informationToSend = capFactory.createInformationToSend(tone);
        txInformationToSendWrapper = new TxInformationToSendWrapper(informationToSend);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInformationToSendWrapper);
        TxInformationToSendWrapper tx = (TxInformationToSendWrapper) deserializeFromFile();

        assertTrue(txInformationToSendWrapper.getTxInformationToSend().getTone().getDuration().intValue() == tx
                .getTxInformationToSend().getTone().getDuration().intValue());
        assertTrue(txInformationToSendWrapper.getTxInformationToSend().getTone().getToneID() == tx
                .getTxInformationToSend().getTone().getToneID());
    }

}
