package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxTimeAndTimezoneWrapperTest extends WrapperBaseTest {

    TxTimeAndTimezoneWrapper txTimeAndTimezoneWrapper;

    @Before
    public void setUp() throws Exception {

        Date date = new Date();
        final TimeAndTimezone timeAndTimezone = capFactory.createTimeAndTimezone(date.getYear(), date.getMonth(),
                date.getDay(), date.getHours(), date.getMinutes(), date.getSeconds(), date.getTimezoneOffset());
        txTimeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txTimeAndTimezoneWrapper);
        TxTimeAndTimezoneWrapper tx = (TxTimeAndTimezoneWrapper) deserializeFromFile();

        assertTrue(
                txTimeAndTimezoneWrapper.getTxTimeAndTimezone().getSecond() == tx.getTxTimeAndTimezone().getSecond());
        assertTrue(txTimeAndTimezoneWrapper.getTxTimeAndTimezone().getTimeZone() == tx.getTxTimeAndTimezone()
                .getTimeZone());
    }

}
