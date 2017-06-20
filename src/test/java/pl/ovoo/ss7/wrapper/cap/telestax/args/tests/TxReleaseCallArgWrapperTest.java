package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCauseWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReleaseCallArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxReleaseCallArgWrapperTest extends WrapperBaseTest {

    TxReleaseCallArgWrapper txReleaseCallArgWrapper;

    @Before
    public void setUp() throws Exception {

        txReleaseCallArgWrapper = new TxReleaseCallArgWrapper();

        final CauseIndicators causeIndicators = isupFactory.createCauseIndicators();
        causeIndicators.setCauseValue(CauseIndicators._CV_BEARER_CAPABILITY_NOT_AUTHORIZED);
        causeIndicators.setCodingStandard(CauseIndicators._CODING_STANDARD_NATIONAL);
        causeIndicators.setDiagnostics(new byte[] { 16 });
        causeIndicators.setLocation(CauseIndicators._LOCATION_INTERNATIONAL_NETWORK);
        causeIndicators.setRecommendation(CauseIndicators._PARAMETER_CODE);

        CauseWrapper causeWrapper = new TxCauseWrapper(causeIndicators);
        txReleaseCallArgWrapper.setInitialCallSegment(causeWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txReleaseCallArgWrapper);
        TxReleaseCallArgWrapper tx = (TxReleaseCallArgWrapper) deserializeFromFile();

        assertTrue(txReleaseCallArgWrapper.getTxCauseIndicators().getCauseValue() == tx.getTxCauseIndicators()
                .getCauseValue());
        assertTrue(txReleaseCallArgWrapper.getTxCauseIndicators().getLocation() == tx.getTxCauseIndicators()
                .getLocation());
        assertTrue(txReleaseCallArgWrapper.getTxCauseIndicators().getCodingStandard() == tx.getTxCauseIndicators()
                .getCodingStandard());
        assertTrue(txReleaseCallArgWrapper.getTxCauseIndicators().getDiagnostics()[0] == tx.getTxCauseIndicators()
                .getDiagnostics()[0]);

    }

}
