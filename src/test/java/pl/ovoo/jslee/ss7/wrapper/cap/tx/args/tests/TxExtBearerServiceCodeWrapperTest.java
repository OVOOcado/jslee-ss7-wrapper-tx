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

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;

import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxExtBearerServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxExtBearerServiceCodeWrapperTest extends WrapperBaseTest {

    TxExtBearerServiceCodeWrapper txExtBearerServiceCodeWrapper;

    @Before
    public void setUp() throws Exception {

        BearerServiceCode bearerServiceCode = mapParameterFactory
                .createBearerServiceCode(BearerServiceCodeValue.allSpeechFollowedByDataCDA);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(bearerServiceCode.getBearerServiceCodeValue());
        txExtBearerServiceCodeWrapper = new TxExtBearerServiceCodeWrapper(extBearerServiceCode);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txExtBearerServiceCodeWrapper);
        TxExtBearerServiceCodeWrapper tx = (TxExtBearerServiceCodeWrapper) deserializeFromFile();

        assertTrue(txExtBearerServiceCodeWrapper.getData()[0] == tx.getData()[0]);
    }

}
