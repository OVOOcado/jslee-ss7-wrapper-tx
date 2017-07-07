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
