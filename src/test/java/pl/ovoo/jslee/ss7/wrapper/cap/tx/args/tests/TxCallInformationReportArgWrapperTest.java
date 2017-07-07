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
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.cap.primitives.DateAndTimeImpl;

import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallInformationReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxRequestedInformationWrapper;

public class TxCallInformationReportArgWrapperTest extends WrapperBaseTest {

    TxCallInformationReportArgWrapper txCallInformationReportArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCallInformationReportArgWrapper = new TxCallInformationReportArgWrapper();
        Date date = new Date();

        DateAndTimeImpl dateAndTime = new DateAndTimeImpl(date.getYear(), date.getMonth(), date.getDay(),
                date.getHours(), date.getMinutes(), date.getSeconds());
        RequestedInformation requestedInformation = capFactory.createRequestedInformation_CallStopTime(dateAndTime);
        RequestedInformationWrapper[] requestedInformationWrapper = new RequestedInformationWrapper[1];
        requestedInformationWrapper[0] = new TxRequestedInformationWrapper(requestedInformation);
        txCallInformationReportArgWrapper.setRequestedInformationList(requestedInformationWrapper);

    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {

        serializeToFile(txCallInformationReportArgWrapper);
        TxCallInformationReportArgWrapper tx = (TxCallInformationReportArgWrapper) deserializeFromFile();

        assertTrue(txCallInformationReportArgWrapper.getTxRequestedInformation().get(0).getCallStopTimeValue()
                .getSecond() == tx.getTxRequestedInformation().get(0).getCallStopTimeValue().getSecond());
    }

}
