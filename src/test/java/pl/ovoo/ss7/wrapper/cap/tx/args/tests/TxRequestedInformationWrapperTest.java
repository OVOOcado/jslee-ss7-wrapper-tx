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

package pl.ovoo.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CauseCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxRequestedInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRequestedInformationWrapperTest extends WrapperBaseTest {

    TxRequestedInformationWrapper txRequestedInformationWrapper;

    @Before
    public void setUp() throws Exception {

        final CauseIndicators causeIndicators = isupFactory.createCauseIndicators();
        causeIndicators.setCauseValue(CauseIndicators._CV_FACILITY_NOT_SUBSCRIBED);
        causeIndicators.setCodingStandard(CauseIndicators._CODING_STANDARD_SPECIFIC);
        causeIndicators.setDiagnostics(new byte[] { 32, 16, 8 });
        causeIndicators.setLocation(CauseIndicators._LOCATION_INTERNATIONAL_NETWORK);
        causeIndicators.setRecommendation(CauseIndicators._PARAMETER_CODE);
        final CauseCap causeCap = capFactory.createCauseCap(causeIndicators);
        final RequestedInformation requestedInformation_ReleaseCause = capFactory
                .createRequestedInformation_ReleaseCause(causeCap);
        txRequestedInformationWrapper = new TxRequestedInformationWrapper(requestedInformation_ReleaseCause);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRequestedInformationWrapper);
        TxRequestedInformationWrapper tx = (TxRequestedInformationWrapper) deserializeFromFile();

        assertTrue(txRequestedInformationWrapper.getRequestedInformationType().getValue() == tx
                .getRequestedInformationType().getValue());
        assertTrue(txRequestedInformationWrapper.getTxRequestedInformation().getReleaseCauseValue().getCauseIndicators()
                .getLocation() == tx.getTxRequestedInformation().getReleaseCauseValue().getCauseIndicators()
                        .getLocation());
    }

}
