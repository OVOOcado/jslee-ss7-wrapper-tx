package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import org.mobicents.protocols.ss7.isup.message.parameter.UserTeleserviceInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxHighLayerCompatibilityWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxHighLayerCompatibilityWrapperTest extends WrapperBaseTest {

    TxHighLayerCompatibilityWrapper txHighLayerCompatibilityWrapper;

    @Before
    public void setUp() throws Exception {

        UserTeleserviceInformation userTeleserviceInformation = isupFactory.createUserTeleserviceInformation();
        userTeleserviceInformation.setCodingStandard(UserTeleserviceInformation._CODING_STANDARD_DFTN);
        userTeleserviceInformation
                .setHighLayerCharIdentification(UserTeleserviceInformation._HLCI_AUDIO_VID_HIGH_RANGE);
        userTeleserviceInformation.setPresentationMethod(UserTeleserviceInformation._PRESENTATION_METHOD_HLPP);
        HighLayerCompatibilityInap highLayerCompatibilityInap = inapFactory
                .createHighLayerCompatibilityInap(userTeleserviceInformation);
        txHighLayerCompatibilityWrapper = new TxHighLayerCompatibilityWrapper(highLayerCompatibilityInap);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txHighLayerCompatibilityWrapper);
        TxHighLayerCompatibilityWrapper tx = (TxHighLayerCompatibilityWrapper) deserializeFromFile();

        assertTrue(txHighLayerCompatibilityWrapper.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                .getHighLayerCharIdentification() == tx.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                        .getHighLayerCharIdentification());
        assertTrue(txHighLayerCompatibilityWrapper.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                .getPresentationMethod() == tx.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                        .getPresentationMethod());
        assertTrue(txHighLayerCompatibilityWrapper.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                .getCodingStandard() == tx.getTxHighLayerCompatibilityInap().getHighLayerCompatibility()
                        .getCodingStandard());

    }

}
