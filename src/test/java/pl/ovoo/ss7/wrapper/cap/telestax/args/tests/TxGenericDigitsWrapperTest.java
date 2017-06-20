package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxGenericDigitsWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxGenericDigitsWrapperTest extends WrapperBaseTest {

    TxGenericDigitsWrapper txGenericDigitsWrapper;

    @Before
    public void setUp() throws Exception {

        GenericDigits genericDigits = isupFactory.createGenericDigits();
        genericDigits.setEncodingScheme(GenericDigits._ENCODING_SCHEME_BCD_ODD);
        genericDigits.setTypeOfDigits(GenericDigitsWrapper.TypeOfDigits.AUTHORISATION_CODE.getValue());
        txGenericDigitsWrapper = new TxGenericDigitsWrapper(genericDigits);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txGenericDigitsWrapper);
        TxGenericDigitsWrapper tx = (TxGenericDigitsWrapper) deserializeFromFile();

        assertTrue(txGenericDigitsWrapper.getTxGenericDigits().getEncodingScheme() == tx.getTxGenericDigits()
                .getEncodingScheme());
        assertTrue(txGenericDigitsWrapper.getTxGenericDigits().getTypeOfDigits() == tx.getTxGenericDigits()
                .getTypeOfDigits());

    }

}
