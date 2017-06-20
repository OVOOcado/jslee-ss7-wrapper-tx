package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyCategory;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallingPartysCategoryWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallingPartysCategoryWrapperTest extends WrapperBaseTest {

    TxCallingPartysCategoryWrapper txCallingPartysCategoryWrapper;

    @Before
    public void setUp() throws Exception {

        CallingPartyCategory callingPartyCategory = isupFactory.createCallingPartyCategory();
        byte bt = 32;
        callingPartyCategory.setCallingPartyCategory(bt);
        CallingPartysCategoryInap callingPartysCategoryInap = inapFactory
                .createCallingPartysCategoryInap(callingPartyCategory);
        txCallingPartysCategoryWrapper = new TxCallingPartysCategoryWrapper(callingPartysCategoryInap);
    }

    @Override
    public void testSerialization() throws Ss7WrapperException, ClassNotFoundException, IOException {

        serializeToFile(txCallingPartysCategoryWrapper);
        TxCallingPartysCategoryWrapper tx = (TxCallingPartysCategoryWrapper) deserializeFromFile();

        assertTrue(txCallingPartysCategoryWrapper.getCategory().getValue() == tx.getCategory().getValue());
    }

}
