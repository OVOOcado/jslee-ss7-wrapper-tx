/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;


/**
 * The Class TxTimeAndTimezoneWrapperTest.
 */
public class TxTimeAndTimezoneWrapperTest extends WrapperBaseTest {

    /** The tx time and timezone wrapper. */
    TxTimeAndTimezoneWrapper txTimeAndTimezoneWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        Date date = new Date();
        final TimeAndTimezone timeAndTimezone = capFactory.createTimeAndTimezone(date.getYear(), date.getMonth(),
                date.getDay(), date.getHours(), date.getMinutes(), date.getSeconds(), date.getTimezoneOffset());
        txTimeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
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
