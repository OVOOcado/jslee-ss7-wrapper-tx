package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.SendingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSendingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2CallInformationRequestArgWrapperTest extends WrapperBaseTest {

    TxCap2CallInformationRequestArgWrapper txCap2CallInformationRequestArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCap2CallInformationRequestArgWrapper = new TxCap2CallInformationRequestArgWrapper();

        final SendingSideID sendingSideID = capFactory.createSendingSideID(LegType.leg2);
        SendingSideIDWrapper sendingideIDWrapper = new TxSendingSideIDWrapper(sendingSideID);
        txCap2CallInformationRequestArgWrapper.setLegID(sendingideIDWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2CallInformationRequestArgWrapper);
        TxCap2CallInformationRequestArgWrapper tx = (TxCap2CallInformationRequestArgWrapper) deserializeFromFile();

        assertTrue(txCap2CallInformationRequestArgWrapper.getLegID().getSendingSideID().getValue() == tx.getLegID()
                .getSendingSideID().getValue());

    }

}
