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

import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper;


/**
 * TxCauseWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCauseWrapper implements CauseWrapper {

	/** The cause. */
	private final CauseIndicators cause;

	/**
	 * Instantiates a new tx cause wrapper.
	 *
	 * @param cause the cause
	 */
	public TxCauseWrapper(final CauseIndicators cause) {
		this.cause = cause;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#getCodingStandard()
	 */
	@Override
	public CodingStandard getCodingStandard() {
		if (cause.getCodingStandard() >= 0) {
			return CodingStandard.valueOf(cause.getCodingStandard());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#getLocation()
	 */
	@Override
	public Location getLocation() {
		if (cause.getLocation() >= 0) {
			return Location.valueOf(cause.getLocation());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#getRecommendation()
	 */
	@Override
	public Recommendation getRecommendation() {
		if (cause.getRecommendation() >= 0) {
			return Recommendation.valueOf(cause.getRecommendation());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#getCauseValue()
	 */
	@Override
	public CauseValue getCauseValue() {
		if (cause.getCauseValue() >= 0) {
			return CauseValue.valueOf(cause.getCauseValue());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#setCodingStandard(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper.CodingStandard)
	 */
	@Override
	public void setCodingStandard(final CodingStandard codingStandard) {
		cause.setCodingStandard(codingStandard.getValue());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#setLocation(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper.Location)
	 */
	@Override
	public void setLocation(final Location location) {
		cause.setLocation(location.getValue());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#setRecommendation(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper.Recommendation)
	 */
	@Override
	public void setRecommendation(final Recommendation recommendation) {
		cause.setRecommendation(recommendation.getValue());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#setCauseValue(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper.CauseValue)
	 */
	@Override
	public void setCauseValue(final CauseValue causeValue) {
		cause.setCauseValue(causeValue.getValue());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper#hasCauseValue()
	 */
	@Override
	public boolean hasCauseValue() {
		return cause.getCauseValue() >= 0;
	}

	/**
	 * Gets the tx cause.
	 *
	 * @return the tx cause
	 */
	public CauseIndicators getTxCause() {
		return cause;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxCauseWrapper [cause=" + cause + "]";
	}

}
