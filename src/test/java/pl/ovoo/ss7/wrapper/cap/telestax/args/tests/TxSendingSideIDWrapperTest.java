package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSendingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxSendingSideIDWrapperTest extends WrapperBaseTest {

    TxSendingSideIDWrapper txSendingSideIDWrapper;

    @Before
    public void setUp() throws Exception {

        final SendingSideID sendingSideID = capFactory.createSendingSideID(LegType.leg2);
        txSendingSideIDWrapper = new TxSendingSideIDWrapper(sendingSideID);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txSendingSideIDWrapper);
        TxSendingSideIDWrapper tx = (TxSendingSideIDWrapper) deserializeFromFile();

        assertTrue(txSendingSideIDWrapper.getSendingSideID().getValue() == tx.getSendingSideID().getValue());
        assertTrue(txSendingSideIDWrapper.getTxSendingSideID().getSendingSideID().getCode() == tx.getTxSendingSideID()
                .getSendingSideID().getCode());

    }

}
