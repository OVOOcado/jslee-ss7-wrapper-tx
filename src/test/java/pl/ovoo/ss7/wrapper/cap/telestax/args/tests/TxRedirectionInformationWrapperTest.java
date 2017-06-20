package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectionInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RedirectionInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRedirectionInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRedirectionInformationWrapperTest extends WrapperBaseTest {

    TxRedirectionInformationWrapper txRedirectionInformationWrapper;

    @Before
    public void setUp() throws Exception {

        final RedirectionInformation redirectionInformation = isupFactory.createRedirectionInformation();
        redirectionInformation.setOriginalRedirectionReason(RedirectionInformation._ORR_USER_BUSY);
        redirectionInformation.setRedirectingIndicator(RedirectionInformation._RI_CALL_D_RNPR);
        redirectionInformation.setRedirectionCounter(2);
        redirectionInformation.setRedirectionReason(RedirectionInformation._RR_MOBILE_SNR);
        final RedirectionInformationInap redirectionInformationInap = inapFactory
                .createRedirectionInformationInap(redirectionInformation);
        txRedirectionInformationWrapper = new TxRedirectionInformationWrapper(redirectionInformationInap);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRedirectionInformationWrapper);
        TxRedirectionInformationWrapper tx = (TxRedirectionInformationWrapper) deserializeFromFile();

        assertTrue(tx.hasOriginalReason());
        assertTrue(tx.hasRedirecting());
        assertTrue(tx.hasRedirectingReason());
        assertEquals(
                txRedirectionInformationWrapper.getTxRedirectionInformation().getRedirectionInformation()
                        .getRedirectingIndicator(),
                tx.getTxRedirectionInformation().getRedirectionInformation().getRedirectingIndicator());

    }

}
