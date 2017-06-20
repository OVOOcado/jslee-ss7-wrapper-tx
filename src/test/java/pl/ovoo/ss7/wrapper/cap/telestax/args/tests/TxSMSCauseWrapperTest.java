package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.MOSMSCause;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.SMSCauseWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSMSCauseWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxSMSCauseWrapperTest extends WrapperBaseTest {

    TxSMSCauseWrapper txSMSCauseWrapper;

    @Before
    public void setUp() throws Exception {

        txSMSCauseWrapper = new TxSMSCauseWrapper(MOSMSCause.releaseFromRadioInterface);
        txSMSCauseWrapper.setFailureCause(SMSCauseWrapper.FailureCause.releaseFromRadioInterface);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txSMSCauseWrapper);
        TxSMSCauseWrapper tx = (TxSMSCauseWrapper) deserializeFromFile();

        assertTrue(txSMSCauseWrapper.getFailureCause().getValue() == tx.getFailureCause().getValue());
        assertTrue(txSMSCauseWrapper.getTxCause().getCode() == tx.getTxCause().getCode());

    }

}
