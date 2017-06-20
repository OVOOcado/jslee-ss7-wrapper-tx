package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCauseWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCauseWrapperTest extends WrapperBaseTest {

    TxCauseWrapper txCauseWrapper;

    @Before
    public void setUp() throws Exception {

        CauseIndicators createCauseIndicators = isupFactory.createCauseIndicators();
        createCauseIndicators.setLocation(CauseIndicators._LOCATION_INTERNATIONAL_NETWORK);
        createCauseIndicators.setCodingStandard(CauseIndicators._CODING_STANDARD_IOS_IEC);
        txCauseWrapper = new TxCauseWrapper(createCauseIndicators);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txCauseWrapper);
        TxCauseWrapper tx = (TxCauseWrapper) deserializeFromFile();

        assertTrue(txCauseWrapper.getTxCause().getCodingStandard() == tx.getTxCause().getCodingStandard());
        assertTrue(txCauseWrapper.getTxCause().getLocation() == tx.getTxCause().getLocation());

    }

}
