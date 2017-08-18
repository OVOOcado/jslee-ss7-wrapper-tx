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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;


/**
 * TxHighLayerCompatibilityWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxHighLayerCompatibilityWrapper implements HighLayerCompatibilityWrapper {

    /** The high layer compatibility inap. */
    private final HighLayerCompatibilityInap highLayerCompatibilityInap;

    /**
     * Instantiates a new tx high layer compatibility wrapper.
     *
     * @param highLayerCompatibilityInap the high layer compatibility inap
     */
    public TxHighLayerCompatibilityWrapper(final HighLayerCompatibilityInap highLayerCompatibilityInap) {
        this.highLayerCompatibilityInap = highLayerCompatibilityInap;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper#hasCharacteristics()
     */
    @Override
    public boolean hasCharacteristics() throws Ss7WrapperException {
        try {
            return highLayerCompatibilityInap.getHighLayerCompatibility() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper#getCharacteristics()
     */
    @Override
    public Characteristics getCharacteristics() throws Ss7WrapperException {
        try {
            return Characteristics.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getHighLayerCharIdentification());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper#getCodingStandard()
     */
    @Override
    public CodingStandard getCodingStandard() throws Ss7WrapperException {
        try {
            return CodingStandard.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getCodingStandard());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper#getInterpretation()
     */
    @Override
    public Interpretation getInterpretation() throws Ss7WrapperException {
        try {
            return Interpretation.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getInterpretation());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper#getPresentation()
     */
    @Override
    public Presentation getPresentation() throws Ss7WrapperException {
        try {
            return Presentation.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getPresentationMethod());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /**
     * Gets the tx high layer compatibility inap.
     *
     * @return the tx high layer compatibility inap
     */
    public HighLayerCompatibilityInap getTxHighLayerCompatibilityInap() {
        return highLayerCompatibilityInap;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxHighLayerCompatibilityWrapper [highLayerCompatibilityInap=" + highLayerCompatibilityInap + "]";
	}
    
}
