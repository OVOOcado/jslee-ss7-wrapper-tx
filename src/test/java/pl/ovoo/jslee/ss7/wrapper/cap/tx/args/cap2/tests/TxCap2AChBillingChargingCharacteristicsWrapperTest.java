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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.tests;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CAPExtensions;
import org.mobicents.protocols.ss7.cap.api.primitives.CriticalityType;
import org.mobicents.protocols.ss7.cap.api.primitives.ExtensionField;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.AudibleIndicator;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2AChBillingChargingCharacteristicsWrapper;


/**
 * The Class TxCap2AChBillingChargingCharacteristicsWrapperTest.
 */
public class TxCap2AChBillingChargingCharacteristicsWrapperTest extends WrapperBaseTest {

    /** The tx cap2 a ch billing charging characteristics wrapper. */
    TxCap2AChBillingChargingCharacteristicsWrapper txCap2AChBillingChargingCharacteristicsWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        final AudibleIndicator audibleIndicator = capFactory.createAudibleIndicator(new Boolean(true));

        final ExtensionField extensionField = capFactory.createExtensionField(1, CriticalityType.typeAbort,
                new byte[] { 64 });
        ArrayList<ExtensionField> extensionFields = new ArrayList<ExtensionField>(1);
        extensionFields.add(extensionField);
        final CAPExtensions capExtensions = capFactory.createCAPExtensions(extensionFields);
        CAMELAChBillingChargingCharacteristics cAMELAChBillingChargingCharacteristics = capFactory
                .createCAMELAChBillingChargingCharacteristics(20L, true, 30L, audibleIndicator, capExtensions, true);
        txCap2AChBillingChargingCharacteristicsWrapper = new TxCap2AChBillingChargingCharacteristicsWrapper(
                cAMELAChBillingChargingCharacteristics);

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2AChBillingChargingCharacteristicsWrapper);
        TxCap2AChBillingChargingCharacteristicsWrapper tx = (TxCap2AChBillingChargingCharacteristicsWrapper) deserializeFromFile();

        assertTrue(txCap2AChBillingChargingCharacteristicsWrapper.getTimeDurationCharging()
                .getMaxCallPeriodDuration() == tx.getTimeDurationCharging().getMaxCallPeriodDuration());
        assertTrue(txCap2AChBillingChargingCharacteristicsWrapper.getTxAchBillingChargingCharacteristics()
                .getExtensions().getExtensionFields().get(0).getCriticalityType().getCode() == tx
                        .getTxAchBillingChargingCharacteristics().getExtensions().getExtensionFields().get(0)
                        .getCriticalityType().getCode());

    }

}
