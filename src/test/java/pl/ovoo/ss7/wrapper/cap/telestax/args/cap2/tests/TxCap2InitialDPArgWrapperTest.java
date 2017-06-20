package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2InitialDPArgWrapperTest extends WrapperBaseTest {

    TxCap2InitialDPArgWrapper txCap2InitialDPArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCap2InitialDPArgWrapper = new TxCap2InitialDPArgWrapper();
        Date date = new Date();

        final TimeAndTimezone timeAndTimezone = capFactory.createTimeAndTimezone(date.getYear(), date.getMonth(),
                date.getDay(), date.getHours(), date.getMinutes(), date.getSeconds(), date.getTimezoneOffset());
        TimeAndTimezoneWrapper timeAndTimeZoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);
        txCap2InitialDPArgWrapper.setTimeAndTimezone(timeAndTimeZoneWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2InitialDPArgWrapper);
        TxCap2InitialDPArgWrapper tx = (TxCap2InitialDPArgWrapper) deserializeFromFile();

        assertTrue(txCap2InitialDPArgWrapper.getTimeAndTimezone().getMinute() == tx.getTimeAndTimezone().getMinute());
    }

}
